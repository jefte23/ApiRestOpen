import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CipComponent } from './cip.component';

describe('CipComponent', () => {
  let component: CipComponent;
  let fixture: ComponentFixture<CipComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CipComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
