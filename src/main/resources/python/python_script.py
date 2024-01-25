import cohere
import constants

co = cohere.Client(constants.API_KEY)

def generate_test_cases(prompt):
    return co.generate(prompt=prompt)