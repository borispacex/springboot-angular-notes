import { Component, OnInit } from '@angular/core';
import { UsersService } from './core/users.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  ngOnInit(){
    console.log('AppComponent initialized');
  }
}
