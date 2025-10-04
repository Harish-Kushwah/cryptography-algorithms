def fuzzy_union(A, B):
    return [max(a, b) for a, b in zip(A, B)]

def fuzzy_intersection(A, B):
    return [min(a, b) for a, b in zip(A, B)]

def fuzzy_complement(A):
    return [1 - a for a in A]

def fuzzy_algebraic_sum(A, B):
    return [a + b - a * b for a, b in zip(A, B)]

def fuzzy_algebraic_product(A, B):
    return [a * b for a, b in zip(A, B)]

def fuzzy_cartesian_product(A, B):
    return [[min(a, b) for b in B] for a in A]


# Example run
A = [0.2, 0.5, 0.7]
B = [0.3, 0.6, 0.4]

print("Union:", fuzzy_union(A, B))
print("Intersection:", fuzzy_intersection(A, B))
print("Complement of A:", fuzzy_complement(A))
print("Algebraic Sum:", fuzzy_algebraic_sum(A, B))
print("Algebraic Product:", fuzzy_algebraic_product(A, B))
print("Cartesian Product:", fuzzy_cartesian_product(A, B))
