import { Component, OnInit, ViewChild } from '@angular/core';
import { isNull } from 'util';
import { AppComponent } from '../app.component';
//import { DataService } from "../data.service";

@Component({
  selector: 'app-crud',
  templateUrl: './crud.component.html',
  styleUrls: ['./crud.component.css']
})
export class CrudComponent implements OnInit {
  
   //Customers:string;

   //constructor(private data: DataService) { }

  Customers = { "Employees": { "Employee": [{ "firstname": "Sarthak", "nickname": "SJ", "salary": 100000, "lastname": "Jain" }, { "firstname": "Neha", "nickname": "NM", "salary": 200000, "lastname": "Mittal" },{ "firstname": "Anshul", "nickname": "AS", "salary": 300000, "lastname": "Sharma" } ] } };

  newitem:any={};

  ngOnInit() {
    //this.data.currentMessage.subscribe(message => this.Customers = message);
  }
  
 Save(item) {
   console.log()
    var index = this.Customers.Employees.Employee.indexOf(item);
    var firstname = document.getElementById('firstname'+index).innerText;
    var nickname = document.getElementById('nickname' + index).innerText;
    var salary = document.getElementById('salary' + index).innerText;
    var lastname = document.getElementById('lastname' + index).innerText;
    item.firstname = firstname;
    item.nickname = nickname;
    item.salary = salary;
    item.lastname = lastname;
    this.Customers.Employees.Employee[index] = item; 
}

Delete(item) {
   var index = this.Customers.Employees.Employee.indexOf(item);
  var firstname = this.Customers.Employees.Employee[index].firstname;
  if (window.confirm("Do you want to delete: " + firstname)) {
    this.Customers.Employees.Employee.splice(index, 1);
  } 
}

Add(item) {
  
  this.Customers.Employees.Employee.push(this.newitem);
  this.newitem = {};
}
}