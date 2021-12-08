import { Injectable } from '@angular/core';
import { HttpClient, JsonpClientBackend } from '@angular/common/http';
import * as L from 'leaflet';
import { MapComponent } from './map.component';


@Injectable({
  providedIn: 'root'
})
export class MarkerService {
  capitals: string = './assets/data/us_capitals.geojson';

  constructor(private http: HttpClient ) { }


  makeCapitalMarkers(map: L.Map,lat:number,lon:number): void {

    const marker = new L.Marker([lat,lon]);
    marker.addTo(map);
   
    //EXEMPLE TUTO CAPITALES US
    // this.http.get(this.capitals).subscribe((res: any) => {
    //   for (const c of res.features) {
    //     const lon = c.geometry.coordinates[0];
    //     const lat = c.geometry.coordinates[1];
    //     const marker = new L.Marker([lat, lon]);

    //     marker.addTo(map);
    //   }
    // });
  }

}
