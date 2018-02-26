import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../customer.service";
import {ICustomer} from "../ICustomer"

@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.css']
})
export class UserlistComponent implements OnInit {
  sname:string="";
  scontact:string="";
  semail:string="";

  customers:ICustomer[];
  clicked:boolean=false;
  uniqueId:string;
  constructor(private  request:CustomerService) { }

  ngOnInit() {
    this.request.loadData()
      .subscribe((data)=>{
        this.customers=data;
  })}
  getData(){
    this.request.loadData().subscribe((data)=>{this.customers=data;})
  }

  show(){

  }

  search(value:string){

    this.request.loadData()
      .subscribe((data) => {
        this.customers = value.length>0?data.filter(function (customer:ICustomer){return (customer.customerName.toLocaleLowerCase().indexOf(value.toLocaleLowerCase())!=-1) || (customer.email.toLocaleLowerCase().indexOf(value.toLocaleLowerCase())!=-1)||(customer.balance.toString().toLocaleLowerCase().indexOf(value.toLocaleLowerCase())!=-1) || (customer.date.toString().toLocaleLowerCase().indexOf(value.toLocaleLowerCase())!=-1)||(customer.contact.toLocaleLowerCase().indexOf(value.toLocaleLowerCase())!=-1)

        } ):data;



        // this.filteredItems=this.items;


      })


  }

  searchuser() {
    let obj={
      sname:this.sname,
      scontact:this.scontact,
      semail:this.semail
    }

      this.request.loadData()
        .subscribe((data) => {
          data = this.sname.length > 0 ? data.filter(function (customer: ICustomer) {
            return (customer.customerName.toLocaleLowerCase().indexOf(obj.sname.toLocaleLowerCase()) != -1)
          }) : data;data = this.semail.length>0?data.filter(function (customer:ICustomer){return (customer.email.toLocaleLowerCase().indexOf(obj.semail.toLocaleLowerCase())!=-1)

          } ):data;this.customers = this.scontact.length>0?data.filter(function (customer:ICustomer){return (customer.contact.toLocaleLowerCase().indexOf(obj.scontact.toLocaleLowerCase())!=-1)
          } ):data;


          // this.filteredItems=this.items;


        })
    }








  setBalance(id:string,amount:any){
    this.request.setBalance(id,amount ).subscribe(res=>{
      this.customers.filter(function (customer:ICustomer){return customer.uniqueId==id})[0].balance+=parseInt(amount);
    this.clicked=false;}
  )
  }


  onrecharge(id){
    this.clicked=true;
    this.uniqueId=id;
  }

  close(){
    this.clicked=false;
  }




}
