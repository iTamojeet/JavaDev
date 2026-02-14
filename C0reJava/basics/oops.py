class Office:
    def __init__(self, name, loc):
        print(f"name is {name} and loc is {loc}")
    
    # def test(self):
    #     print("I am office class")

    def test(self, a):
        print("1 args method ",a,type(a))

def test():
    print("Procedural code")

test()

# Office().test()

o = Office("IBM","Kolkata")

o.test(True)
o.test([1,2,3])
o.test("")

# o.name='IBM'
# o.loc='Kolkata'
# print(f"name is {o.name} and loc is {o.loc}")