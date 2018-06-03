import { Component, OnInit } from '@angular/core';
import {UserserviceService} from '../../sharedservice/userservice.service'
import {User} from '../../user'

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {

  private users : User =new User (0,'','','','','',0,0,0,0,'','','','');

  constructor(private userservice : UserserviceService) { 
    console.log("constructor ran for user-info")
  }

  ngOnInit() {
    this.login();
    }

    public login():void{

      this.userservice.getUser(this.users).subscribe(
        data => {
          this.users =<User>data;
          console.log(data);
        },error => {
          console.log("error");
        }
      )
    }
  }


