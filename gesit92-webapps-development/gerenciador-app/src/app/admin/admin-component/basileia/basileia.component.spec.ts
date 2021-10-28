import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BasileiaComponent } from './basileia.component';

describe('BasileiaComponent', () => {
  let component: BasileiaComponent;
  let fixture: ComponentFixture<BasileiaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BasileiaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BasileiaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
