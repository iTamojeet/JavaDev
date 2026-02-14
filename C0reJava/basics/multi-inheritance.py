class A:
    def sum(self,a,b):
        return a+b
    def show(self):
        print("hi from A")

class B:
    def multi(self,a,b):
        return a*b
    def show(self):
        print("hi from B")

class D(B,A):
    ...

d = D()
d.show()

print(d.sum(1,2))
print(d.multi(1,2))