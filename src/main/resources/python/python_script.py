import cohere
import constants


def generate_test_cases(prompt):
    """
    This method generates test cases by calling Cohere's generate API.

    @:param prompt: The prompt for test case generation in string format.
    @:returns: String output of generated test cases with explanation.

    """
    co = cohere.Client(constants.API_KEY)
    return co.generate(prompt=prompt)