import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CadernoPlataformaComponent } from './caderno-plataforma.component';

describe('CadernoPlataformaComponent', () => {
  let component: CadernoPlataformaComponent;
  let fixture: ComponentFixture<CadernoPlataformaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CadernoPlataformaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CadernoPlataformaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
