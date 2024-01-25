import cohere

co = cohere.Client('IOEAd82k1XlgV2UHEQ9kDgvUhoALkF5j9TyIy9r6')

def generate_test_cases(prompt):
    return co.generate(prompt=prompt)