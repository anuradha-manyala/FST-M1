import pytest

@pytest.fixture
def num_list():
    numbers = list(range(11))
    return numbers
