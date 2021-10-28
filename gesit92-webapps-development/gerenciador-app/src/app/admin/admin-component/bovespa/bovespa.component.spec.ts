import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BovespaComponent } from './bovespa.component';

describe('BovespaComponent', () => {
  let component: BovespaComponent;
  let fixture: ComponentFixture<BovespaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BovespaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BovespaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
