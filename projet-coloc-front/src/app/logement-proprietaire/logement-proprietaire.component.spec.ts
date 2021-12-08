import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogementProprietaireComponent } from './logement-proprietaire.component';

describe('LogementProprietaireComponent', () => {
  let component: LogementProprietaireComponent;
  let fixture: ComponentFixture<LogementProprietaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LogementProprietaireComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LogementProprietaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
