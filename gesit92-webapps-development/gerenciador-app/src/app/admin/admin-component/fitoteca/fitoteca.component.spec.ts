import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FitotecaComponent } from './fitoteca.component';

describe('FitotecaComponent', () => {
  let component: FitotecaComponent;
  let fixture: ComponentFixture<FitotecaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FitotecaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FitotecaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
