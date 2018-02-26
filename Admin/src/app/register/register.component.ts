import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../customer.service"

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  uniqueId: string;
  clicked = false;
  customerName: string;
  date: Date;
  contact: string;
  email: string;
  dummyImage: string;
  idProof: FileList;

  today = new Date();
  minage = 18;
  minAge = new Date(this.today.getFullYear() - this.minage, this.today.getMonth(), this.today.getDate());




  constructor(private request: CustomerService) {
  }

  ngOnInit() {
  }


  addCustomer(customerName, date, contact, email) {
    let file = this.idProof;
    if (file[0].name.endsWith("png") || file[0].name.endsWith("jpg")) {
      let customer = {
        customerName: customerName,
        date: date,
        contact: contact,
        email: email,
        identityProof: undefined
    }
      ;

      let reader: FileReader = new FileReader();

      reader.onload = (event: Event) => {
        let binaryString: any = (event.target as FileReader).result;
        customer.identityProof = btoa(binaryString);
        this.request.postData(customer).subscribe((data) => {
          this.uniqueId = data.text();
          console.dir(data.text())
        })
      }
      reader.readAsBinaryString(file[0]);

      this.customerName = "";
      this.date = null;
      this.contact = "";
      this.email = "";
      this.idProof=null;


      this.clicked = true;
    }
  }

  close(){
    this.clicked=false;
      }

  setProofOfId(event : Event)
  {
    this.idProof= event.target['files'];
  }

}
