package woongjin.hurryup.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import woongjin.hurryup.DTO.MemberDTO;
import woongjin.hurryup.entity.Member;

@Mapper
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    @Mapping(target = "memberId", source = "memberId")
    @Mapping(target = "nickname", source = "nickname")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "createdAt", source = "createdAt") // 매핑 추가
    MemberDTO memberToMemberDTO(Member member);

    // 필요시 DTO에서 엔티티로의 매핑도 추가할 수 있습니다.
    @Mapping(target = "createdAt", source = "createdAt")
    Member memberDTOToMemberr(MemberDTO memberDTO);
}
