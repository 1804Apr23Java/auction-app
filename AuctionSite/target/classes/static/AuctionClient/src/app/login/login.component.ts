import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserserviceService } from '../sharedservice/userservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
   public user:User = new User(0,'','','','','',0,0,0,0,'','','','');
   public userdata:User = new User(0,'','','','','',0,0,0,0,'','','','');

  constructor(private userservice:UserserviceService) { }

  ngOnInit() {
  }

  public login():void{
    this.userservice.getUser(this.user).subscribe(
      data =>{
        this.user=<User>data;
        console.log(data);
      },
      error =>{
        console.log("Error");
      }

    )
  }

}
