package mainApp.controllers;

import mainApp.entities.Member;
import mainApp.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/member-controller")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping(value = "/createMember")
    public ResponseEntity<Member> create(@RequestBody Member member) {
        return new ResponseEntity<Member>(memberService.create(member), HttpStatus.CREATED);
    }

    @GetMapping(value = "/read{id}")
    public ResponseEntity<Member> read(@PathVariable Long id) {
        return new ResponseEntity<Member>(memberService.read(id), HttpStatus.OK);
    }

    @GetMapping(value = "/readAll")
    public ResponseEntity<Iterable<Member>> readAll() {
        return new ResponseEntity<>(memberService.readAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/update{id}")
    public ResponseEntity<Member> update(@PathVariable Long id, @RequestBody Member member) {
        return new ResponseEntity<>(memberService.update(id, member), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Member> delete(@PathVariable Long id) {
        return new ResponseEntity<>(memberService.delete(id), HttpStatus.OK);
    }
}
