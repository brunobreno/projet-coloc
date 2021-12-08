import { HttpClient } from '@angular/common/http';
import { Component, AfterViewInit } from '@angular/core';
import * as L from 'leaflet';
import { DescriptionLogementComponent } from '../description-logement/description-logement.component';
import { Logement } from '../model';
import { RechercheLogementService } from '../recherche-logement/recherche-logement.service';
import { MapHttpService } from './map-http.service';
import { MarkerService } from './marker.service';



const iconRetinaUrl = 'assets/marker-icon-2x.png';
const iconUrl = 'assets/marker-icon.png';
const shadowUrl = 'assets/marker-shadow.png';
const iconDefault = L.icon({
  iconRetinaUrl,
  iconUrl,
  shadowUrl,
  iconSize: [25, 41],
  iconAnchor: [12, 41],
  popupAnchor: [1, -34],
  tooltipAnchor: [16, -28],
  shadowSize: [41, 41]
});
L.Marker.prototype.options.icon = iconDefault;


@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})
export class MapComponent implements AfterViewInit {
  map: any;



  constructor(private http: HttpClient, private markerService: MarkerService, private recherLogementService: RechercheLogementService, private descriptionLogement:DescriptionLogementComponent) { }


  listeCoord: Array<number> = new Array<number>();
  resultat: any;
  lat: any;
  lon: any;
  log:Logement;
  cp: string;
  city:string;
  voie:string;
  num:number;

  initMap(): void {

    console.log("lat " + this.lat);
    console.log("lon " + this.lon);

    if(this.lat == undefined || this.lon == undefined){
      this.map = L.map('map', {
        center: [46.227638, 2.213749],
        zoom: 6
      });
    }else{
      this.map = L.map('map', {
        center: [this.lat, this.lon],
        zoom: 12
      });
    }

    

    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 18,
      minZoom: 3,
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    });

    tiles.addTo(this.map);
  }

  getCoordLogement(){
    let promise = new Promise<void>((resolve, reject) => {
      this.log = this.descriptionLogement.logement;
      this.cp = this.log.localisation.codePostal;
      this.city = this.log.localisation.ville;
      this.num = this.log.localisation.num;
      this.voie = this.log.localisation.voie;
      this.voie = this.voie.replace(/ /g, '+');
      let apiUrl = `https://api-adresse.data.gouv.fr/search/?q=${this.num}+${this.voie}+${this.cp}+&city=${this.city}&limit=1`;
      this.http.get(apiUrl)
        .toPromise()
        .then(
          res => {
            console.log('resultat api : ' + JSON.stringify(res));
            this.resultat = res;
            for (const c of this.resultat.features) {
              this.lon = c.geometry.coordinates[0];
              this.lat = c.geometry.coordinates[1];
              console.log(this.lat)
              console.log(this.lon)
            }
            resolve(this.initMap());
            resolve(this.markerService.makeCapitalMarkers(this.map,this.lat,this.lon));
          }
        );

    });
    return promise;
  }

  
  getCoordVille() {
    let promise = new Promise<void>((resolve, reject) => {
      let apiUrl = `https://api-adresse.data.gouv.fr/search/?q=${this.recherLogementService.filtreVille}&limit=1`;
      this.http.get(apiUrl)
        .toPromise()
        .then(
          res => {
            console.log('resultat api : ' + JSON.stringify(res));
            this.resultat = res;
            for (const c of this.resultat.features) {
              this.lon = c.geometry.coordinates[0];
              this.lat = c.geometry.coordinates[1];
              console.log(this.lat)
              console.log(this.lon)

            }
            resolve(this.initMap());
            resolve(this.markerService.makeCapitalMarkers(this.map,this.lat,this.lon));
          }
        );

    });
    return promise;
  }
  

  ngAfterViewInit(): void {
    
  }

}