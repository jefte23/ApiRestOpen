import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MetodosEstatisticosComponent } from './metodos-estatisticos.component';

describe('MetodosEstatisticosComponent', () => {
  let component: MetodosEstatisticosComponent;
  let fixture: ComponentFixture<MetodosEstatisticosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MetodosEstatisticosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MetodosEstatisticosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
