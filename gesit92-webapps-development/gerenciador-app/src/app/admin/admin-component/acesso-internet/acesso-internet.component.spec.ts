import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AcessoInternetComponent } from './acesso-internet.component';

describe('AcessoInternetComponent', () => {
  let component: AcessoInternetComponent;
  let fixture: ComponentFixture<AcessoInternetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AcessoInternetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AcessoInternetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
