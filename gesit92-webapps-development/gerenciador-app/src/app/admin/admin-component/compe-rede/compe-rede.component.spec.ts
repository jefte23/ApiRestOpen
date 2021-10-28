import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompeRedeComponent } from './compe-rede.component';

describe('CompeRedeComponent', () => {
  let component: CompeRedeComponent;
  let fixture: ComponentFixture<CompeRedeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompeRedeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompeRedeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
