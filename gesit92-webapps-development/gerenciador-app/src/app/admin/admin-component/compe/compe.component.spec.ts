import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompeComponent } from './compe.component';

describe('CompeComponent', () => {
  let component: CompeComponent;
  let fixture: ComponentFixture<CompeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
