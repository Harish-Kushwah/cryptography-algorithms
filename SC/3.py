def fuzzy_union(A, B):
    return [max(a, b) for a, b in zip(A, B)]

def fuzzy_intersection(A, B):
    return [min(a, b) for a, b in zip(A, B)]

def fuzzy_complement(A):
    return [1 - a for a in A]

# Example check for De Morgan’s Law
A = [0.2, 0.5, 0.7]
B = [0.3, 0.6, 0.4]

lhs1 = fuzzy_complement(fuzzy_union(A, B))
rhs1 = fuzzy_intersection(fuzzy_complement(A), fuzzy_complement(B))

lhs2 = fuzzy_complement(fuzzy_intersection(A, B))
rhs2 = fuzzy_union(fuzzy_complement(A), fuzzy_complement(B))

print("¬(A ∪ B) =", lhs1)
print("¬A ∩ ¬B =", rhs1)
print("¬(A ∩ B) =", lhs2)
print("¬A ∪ ¬B =", rhs2)
