package com.example.easynotes;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EasyNotesApplicationTests {
    @Autowired
    private NoteRepository noteRepository;
    @Before
    public void setUp() throws Exception {
        Note note1= new Note("Alice", "AliceContent");
        Note note2= new Note("Bob", "BobContent");
        //save user, verify has ID value after save
        assertNull(note1.getId());
        assertNull(note2.getId());//null before save
        this.noteRepository.save(note1);
        this.noteRepository.save(note2);
        assertNotNull(note1.getId());
        assertNotNull(note2.getId());
    }

    @Test
    public void testFetchData(){
        /*Test data retrieval*/
		/*
		 * Note noteA = noteRepository.findById(); assertNotNull(noteA);
		 * assertEquals("AliceContent", noteA.getContent());
		 */
        /*Get all products, list should only have two*/
        Iterable<Note> notes = noteRepository.findAll();
        int count = 0;
        for(Note p : notes){
            count++;
        }
        assertEquals(count, 2);
    }
	@Test
	public void contextLoads() {
	}
}



