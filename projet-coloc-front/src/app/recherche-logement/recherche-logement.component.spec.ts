import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercheLogementComponent } from './recherche-logement.component';

describe('RechercheLogementComponent', () => {
  let component: RechercheLogementComponent;
  let fixture: ComponentFixture<RechercheLogementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RechercheLogementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RechercheLogementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
