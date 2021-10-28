import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultaRtcComponent } from './consulta-rtc.component';

describe('ConsultaRtcComponent', () => {
  let component: ConsultaRtcComponent;
  let fixture: ComponentFixture<ConsultaRtcComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultaRtcComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultaRtcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
