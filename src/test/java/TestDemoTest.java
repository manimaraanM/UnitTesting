import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
//import org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDemoTest {
private TestDemo testDemo;
private TestDemo mockDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo=new TestDemo();
	}

	
	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a ,int b,int expected,boolean expectException) {
	
		if(!expectException) {
		    assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
			
			}
		else {
			assertThatThrownBy(() -> 
		    testDemo.addPositive(a, b))
		        .isInstanceOf(IllegalArgumentException.class);	
		}
		}
	
	
	static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(
				arguments(10,5,15,false),
				arguments(-5,5,15,true),
				arguments(5,5,20,false)
				);
		
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		//fail("Not yet implemented");
		 mockDemo = spy(testDemo);
		 doReturn(5).when(mockDemo).getRandomInt();
		 int fiveSquared = mockDemo.randomNumberSquared();
		 assertThat(fiveSquared).isEqualTo(25);
	
	}
	
	

}
