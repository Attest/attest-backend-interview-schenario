// Package survey implements methods for calculating
// the path a respondent should take through a survey.
package survey

import (
	"github.com/Attest/backend-test/go/model"
	"github.com/Attest/backend-test/go/survey/internal/dao"
)

var _ questionDao = (*dao.InMemQuestionDao)(nil)
var _ surveyDao = (*dao.InMemSurveyDao)(nil)
var _ takerQuestionAnswerDao = (*dao.InMemTakerQuestionAnswerDao)(nil)

type questionDao interface {
	Questions(ids []int) ([]model.Question, error)
	Question(id int) (*model.Question, error)
}

type surveyDao interface {
	QuestionIds(surveyID int) ([]int, error)
}

type takerQuestionAnswerDao interface {
	QuestionAnswers(takerID int, questionIDs []int) ([]model.TakerQuestionAnswer, error)
}

// Progress represents the current state of a respondent in a survey.
// It holds the next question to be answers, or nil if no questions, and
// other information about the progress and potential progress in the survey.
type Progress struct {
	// Question is the next question available for the respondent, or nil.
	Question *model.Question

	// NumAnswered is the number of questions answered by the taker in the survey.
	NumAnswered int

	// MaxQuestions is the max number of questions available to a respondent in the survey.
	MaxQuestions int

	// The total amount paid to a taker so far.
	TotalPaid int
}

// Service holds all the dao objects required to
// retrieve survey, question and answer information.
type Service struct {
	questions questionDao
	surveys   surveyDao
	answers   takerQuestionAnswerDao
}

// NewInMemService is a constructor for a
// new *Service using mock / in memory daos.
func NewInMemService() *Service {
	return &Service{
		questions: dao.NewInMemQuestionDao(),
		surveys:   dao.NewInMemSurveyDao(),
		answers:   dao.NewInMemTakerQuestionAnswerDao(),
	}
}

// NewService is a constructor for a new *Service
// with the given dao objects.
func NewService(questions questionDao, surveys surveyDao, answers takerQuestionAnswerDao) *Service {
	return &Service{
		questions: questions,
		surveys:   surveys,
		answers:   answers,
	}
}

// Progress reports the state of the survey for a respondent (taker).
func (s *Service) Progress(takerID int, surveyID int) (Progress, error) {
	panic("implement me!")
}
