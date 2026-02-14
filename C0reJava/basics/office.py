class Emp:
    # class variable are shareable among all the variables of a class
    inc_factor=1.3

    def __init__(self, firstname, lastname, pay):
        self.firstname=firstname
        self.lastname=lastname
        self.pay=pay
        self.fullname=self.firstname+' '+self.lastname
        print(self.fullname+" "+str(id(self)))

    def inc(self):
        return self.pay*Emp.inc_factor

    def email(self):
        return self.firstname+"@ibm.com"
    
e=Emp("Tamojeet","Pal",10000)
print(f"{e.fullname} with email {e.email()} gets ₹ {e.pay}")
print(f"{e.fullname} with email {e.email()} gets ₹ {e.inc()}")
print(e.__dict__)
di=e.__dict__
print(type(di))
print("*"*69)

import json
jst=json.dumps(di)
print(jst,type(jst))

print("*"*69)

class Manager(Emp):
    def __init__(self, firstname, lastname, pay, allocate_project):
        # Emp.__init__(self,firstname,lastname,pay)
        super().__init__(firstname,lastname,pay)
        self.allocate_project=allocate_project
        print(self.fullname+" "+str(id(self)))
        print("allocated project is ",self.allocate_project)

m=Manager("Dhur","Bara",50000,"Spring Boot")
print(f"{m.fullname} with email {m.email()} gets ₹ {m.pay} and project is {m.allocate_project}")