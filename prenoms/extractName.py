male = []
female = []
with open("Prenoms.csv") as f:
    print(f.readline())
    for line in f:
        L = line.split(";")
        name = L[0]
        genre = L[1]
        if genre == "f":
            female.append(name)
        elif genre =="m":
            male.append(name)
        else :
            print(genre)
