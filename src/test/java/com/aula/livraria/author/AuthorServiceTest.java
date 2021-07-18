package com.aula.livraria.author;

import com.aula.livraria.exceptions.AuthorNotFoundException;
import com.aula.livraria.exceptions.ValidationLengthException;
import com.aula.livraria.exceptions.ValidationNullableException;
import com.aula.livraria.model.author.Author;
import com.aula.livraria.model.author.AuthorDTO;
import com.aula.livraria.model.enums.Gender;
import com.aula.livraria.repository.author.AuthorRepository;
import com.aula.livraria.rest.author.AuthorServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class AuthorServiceTest {

    @Mock
    AuthorRepository authorRepository;

    @InjectMocks
    AuthorServiceImpl authorServiceImpl;

    AuthorDTO authorDTO;

    // Ele executar antes de executar o nosso teste
    @Before
    public void init() {
        this.authorDTO = AuthorDTO.builder().name("teste").gender(Gender.MALE).build();
    }

    @Test
    public void getAuthorByIdWithValidId() throws AuthorNotFoundException {
        this.authorDTO.setId(1L);
        Author author = AuthorDTO.toEntity(this.authorDTO);

        Mockito.when(this.authorRepository.findById(1L)).thenReturn(Optional.of(author));

        AuthorDTO returnTest = this.authorServiceImpl.findById(1L);

        Assert.assertNotNull(returnTest);
        Assert.assertEquals(returnTest, this.authorDTO);
    }

    @Test(expected = AuthorNotFoundException.class)
    public void getAuthorByIdWithInvalidId() throws AuthorNotFoundException {
        this.authorServiceImpl.findById(2L);
    }

    @Test
    public void createAuthorWithGenderMale() throws ValidationNullableException, ValidationLengthException {

        Author authorBeforeSave = AuthorDTO.toEntity(this.authorDTO);
        Author authorAfterSave = AuthorDTO.toEntity(this.authorDTO);
        authorAfterSave.setId(1L);

        Mockito.when(this.authorRepository.save(authorBeforeSave)).thenReturn(authorAfterSave);

        AuthorDTO entity = this.authorServiceImpl.createAuthor(this.authorDTO);

        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getGender(), Gender.MALE);
    }

    @Test
    public void createAuthorWithGenderFemale() throws ValidationNullableException, ValidationLengthException {
        this.authorDTO.setGender(Gender.FEMALE);

        Author authorBeforeSave = AuthorDTO.toEntity(this.authorDTO);
        Author authorAfterSave = AuthorDTO.toEntity(this.authorDTO);
        authorAfterSave.setId(1L);

        Mockito.when(this.authorRepository.save(authorBeforeSave)).thenReturn(authorAfterSave);

        AuthorDTO entity = this.authorServiceImpl.createAuthor(this.authorDTO);

        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getGender(), Gender.FEMALE);
    }

    @Test(expected = ValidationNullableException.class)
    public void createAuthorWithGenderNullThrowError() throws ValidationNullableException, ValidationLengthException {
        this.authorDTO.setGender(null);
        this.authorServiceImpl.createAuthor(this.authorDTO);
    }

    @Test(expected = ValidationNullableException.class)
    public void createAuthorWithNameNullThrowError() throws ValidationNullableException, ValidationLengthException {
        this.authorDTO.setName(null);
        this.authorServiceImpl.createAuthor(this.authorDTO);
    }

    @Test(expected = ValidationLengthException.class)
    public void createAuthorWithNameLengthMoreThen20() throws ValidationNullableException, ValidationLengthException {
        this.authorDTO.setName("Fernando Rafael Lopes Murta Maior de 20");
        this.authorServiceImpl.createAuthor(this.authorDTO);
    }

}
