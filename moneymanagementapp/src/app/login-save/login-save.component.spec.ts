import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginSaveComponent } from './login-save.component';

describe('LoginSaveComponent', () => {
  let component: LoginSaveComponent;
  let fixture: ComponentFixture<LoginSaveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginSaveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginSaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
