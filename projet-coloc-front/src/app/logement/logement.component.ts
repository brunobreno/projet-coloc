import { Component, OnInit } from '@angular/core';
import { Logement } from '../model';
import { LogementHttpService } from './logement-http.service';

@Component({
  selector: 'app-logement',
  templateUrl: './logement.component.html',
  styleUrls: ['./logement.component.scss']
})
export class LogementComponent implements OnInit {

  logementForm: Logement;
  logement: Logement;
  filtre: string;

  constructor(private logementService: LogementHttpService) { }

  ngOnInit(): void {
  }

  list(): Array<Logement> {
    return this.logementService.findAll();
  }

  add() {
    this.logementForm = new Logement();
  }

  edit(id: number) {
    this.logementService.findById(id).subscribe(response => {
      this.logementForm = response;
    }, err => console.log(err));
  }

  save() {
      this.logementService.modify(this.logementForm);
  }

  cancel() {
    this.logementForm = null;
  }

  remove(id: number) {
    this.logementService.deleteById(id);
  }

}
