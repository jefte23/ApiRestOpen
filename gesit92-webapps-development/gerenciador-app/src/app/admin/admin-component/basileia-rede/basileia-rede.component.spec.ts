import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BasileiaRedeComponent } from './basileia-rede.component';

describe('BasileiaRedeComponent', () => {
  let component: BasileiaRedeComponent;
  let fixture: ComponentFixture<BasileiaRedeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BasileiaRedeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BasileiaRedeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
