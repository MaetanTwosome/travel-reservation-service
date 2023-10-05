package maetanTwosome.trs.room.fixture;

import maetanTwosome.trs.room.entity.Room;

public class RoomFixture {

    public static Room createRoom() {
        return Room.builder()
                .id(1L)
                .name("스탠다드 객실")
                .type("스탠다드")
                .dayUsePrice("10000")
                .stayUsePrice("80000")
                .status("1")
                .content("넷플릭스 이용 가능")
                .build();
    }
}
