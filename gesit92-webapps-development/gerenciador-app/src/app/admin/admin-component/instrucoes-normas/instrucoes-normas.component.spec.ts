import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InstrucoesNormasComponent } from './instrucoes-normas.component';

describe('InstrucoesNormasComponent', () => {
  let component: InstrucoesNormasComponent;
  let fixture: ComponentFixture<InstrucoesNormasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InstrucoesNormasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InstrucoesNormasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
