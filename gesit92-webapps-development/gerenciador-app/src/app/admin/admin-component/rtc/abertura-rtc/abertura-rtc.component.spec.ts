import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AberturaRtcComponent } from './abertura-rtc.component';

describe('AberturaRtcComponent', () => {
  let component: AberturaRtcComponent;
  let fixture: ComponentFixture<AberturaRtcComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AberturaRtcComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AberturaRtcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
