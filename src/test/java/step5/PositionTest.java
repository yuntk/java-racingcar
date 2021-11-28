package step5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step5.dto.Position;

class PositionTest {

    @Test
    @DisplayName("위치 객체의 기본 위치값은 0 이다")
    public void defaultPosition() {
        Position position = new Position();

        Assertions.assertThat(position.getCurrentPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"5,6", "7,8", "1,2", "10,11", "15,16"})
    @DisplayName("plus 메서드는 위치를 1만큼 더한 새로운 객체를 반환한다.")
    public void newPosition(int input, int expected) {
        Assertions.assertThat(new Position(input).plusPosition()).isEqualTo(new Position(expected));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -5})
    @DisplayName("0 미만의 값을 받을 시 예외를 던진다")
    public void zeroException(int input) {
        Assertions.assertThatThrownBy(() -> {
            new Position(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}