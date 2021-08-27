import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserLoginsComponent } from './userLogins.component';

describe('UserLoginsComponent', () => {
  let component: UserLoginsComponent;
  let fixture: ComponentFixture<UserLoginsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserLoginsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserLoginsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
