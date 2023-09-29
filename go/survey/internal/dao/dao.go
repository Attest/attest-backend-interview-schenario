package dao

import (
	"errors"

	"github.com/Attest/backend-test/go/model"
)

// ErrNotFound is a sentinel error reporting a dao cannot find results
var ErrNotFound = errors.New("dao error: not found")

// InMemQuestionDao mocks a questionDao providing data from memory
type InMemQuestionDao struct {
	qs []model.Question
}

// Questions retrieves the inmemory questions by given ids or an error
func (dao *InMemQuestionDao) Questions(ids []int) ([]model.Question, error) {
	qs := make([]model.Question, 0, len(ids))

	fIds := flattenInts(ids)

	for _, q := range dao.qs {
		if fIds[q.ID] {
			qs = append(qs, q)
		}
	}

	if len(qs) == 0 {
		return nil, ErrNotFound
	}

	return qs, nil
}

// Question retrieves a single Question from in memory by id
func (dao *InMemQuestionDao) Question(id int) (*model.Question, error) {
	qs, err := dao.Questions([]int{id})
	if err != nil {
		return nil, err
	}

	if qs == nil || len(qs) == 0 {
		return nil, ErrNotFound
	}

	return &(qs[0]), nil
}

func flattenInts(vals []int) map[int]bool {
	m := make(map[int]bool)
	for _, v := range vals {
		m[v] = true
	}

	return m
}

// InMemSurveyDao mocks a surveyDao providing data from memory
type InMemSurveyDao struct {
	ids map[int][]int
}

// QuestionIds retrieves the ids of questions in a survey, from memory, or an error
func (dao *InMemSurveyDao) QuestionIds(surveyID int) ([]int, error) {
	ids, ok := dao.ids[surveyID]
	if !ok {
		return nil, ErrNotFound
	}
	return ids, nil
}

// InMemTakerQuestionAnswerDao mocks a takerQuestionAnswerDao providing data form memory
type InMemTakerQuestionAnswerDao struct {
	answers map[int][]model.TakerQuestionAnswer
}

// QuestionAnswers retrieves TakerQuestionAnswers for given taker and question ids from memory, or an error.
func (dao *InMemTakerQuestionAnswerDao) QuestionAnswers(takerID int, questionIDs []int) ([]model.TakerQuestionAnswer, error) {
	takerAns, ok := dao.answers[takerID]
	if !ok {
		return nil, ErrNotFound
	}

	fAns := flattenTQAs(takerAns)
	var tqas []model.TakerQuestionAnswer

	for _, id := range questionIDs {
		if tqa, ok := fAns[id]; ok {
			tqas = append(tqas, tqa)
		}
	}

	if len(tqas) == 0 {
		return nil, ErrNotFound
	}

	return tqas, nil
}

// QuestionAnswer retrieves a TakerQuestionAnswer given a taker and question id from memory, or an error.
func (dao *InMemTakerQuestionAnswerDao) QuestionAnswer(takerID int, questionID int) (*model.TakerQuestionAnswer, error) {
	as, err := dao.QuestionAnswers(takerID, []int{questionID})
	if err != nil {
		return nil, err
	}

	if as == nil || len(as) == 0 {
		return nil, ErrNotFound
	}

	return &(as[0]), nil
}

func flattenTQAs(tqas []model.TakerQuestionAnswer) map[int]model.TakerQuestionAnswer {
	m := make(map[int]model.TakerQuestionAnswer)
	for _, v := range tqas {
		m[v.QuestionID] = v
	}

	return m
}
