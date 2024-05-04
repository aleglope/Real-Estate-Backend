import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { StorageService } from '../../services/storage.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-imagen',
  templateUrl: './add-imagen.component.html',
  styleUrls: ['./add-imagen.component.css'],
})
export class AddImagenComponent implements OnInit {
  @ViewChild('imagen') imagen: ElementRef<HTMLInputElement>;
  id: number;
  filesToUpload: File[] = [];
  imagePreviews: string[] = [];
  aUrlImagenes: any[] = [];

  constructor(
    private _storageService: StorageService,
    private _router: Router,
    private _route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this._route.params.subscribe((params) => {
      this.id = params['id'];
    });
  }

  upload(event: any): void {
    const files = Array.from(event.target.files) as File[];
    this.filesToUpload = files;
    this.imagePreviews = [];

    files.forEach((file) => {
      const reader = new FileReader();
      reader.onload = (e: any) => {
        this.imagePreviews.push(e.target.result);
      };
      reader.readAsDataURL(file);
    });
  }

  sendImagenes(): void {
    if (this.filesToUpload.length === 0) {
      alert('Por favor, seleccione al menos un archivo para subir.');
      return;
    }

    for (const file of this.filesToUpload) {
      const formData = new FormData();
      formData.append('file', file);

      this._storageService.uploadFile(formData, this.id).subscribe({
        next: (response) => {
          this.aUrlImagenes.push(response.url);
          alert('Imágenes subidas con éxito');
        },
        error: (e) => {
          console.error('Error uploading file:', e);
          this._router.navigate(['/error']);
        },
        complete: () => {
          this._router.navigate(['/list-inmueble']);
        },
      });

      this.filesToUpload = [];
      this.imagePreviews = [];
      if (this.imagen.nativeElement) {
        this.imagen.nativeElement.value = '';
      }
    }
  }
}
