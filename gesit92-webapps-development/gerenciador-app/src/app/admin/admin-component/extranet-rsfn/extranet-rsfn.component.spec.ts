import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExtranetRsfnComponent } from './extranet-rsfn.component';

describe('ExtranetRsfnComponent', () => {
  let component: ExtranetRsfnComponent;
  let fixture: ComponentFixture<ExtranetRsfnComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExtranetRsfnComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExtranetRsfnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
