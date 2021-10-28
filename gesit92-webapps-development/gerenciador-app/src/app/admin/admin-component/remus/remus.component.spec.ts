import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RemusComponent } from './remus.component';

describe('RemusComponent', () => {
  let component: RemusComponent;
  let fixture: ComponentFixture<RemusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RemusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RemusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
