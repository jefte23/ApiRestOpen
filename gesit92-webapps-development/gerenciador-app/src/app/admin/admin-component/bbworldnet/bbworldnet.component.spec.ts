import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BbworldnetComponent } from './bbworldnet.component';

describe('BbworldnetComponent', () => {
  let component: BbworldnetComponent;
  let fixture: ComponentFixture<BbworldnetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BbworldnetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BbworldnetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
