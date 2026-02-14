class Emp:
    def __init__(this,name,sal):
        this.name=name
        this.sal=sal
        print(f"{this.name} gets ₹ {this.sal}")

    def __add__(this,other):
        return this.sal+other.sal

    def __mul__(this,other):
        return this.sal-other.sal

e1=Emp("Dhur",50000)
e2=Emp("Tamo",70000)

print(e1+e2)
print(e1*e2)