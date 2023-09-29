// Package model defines a number of structs that
// represent the objects for questions and surveys.
package model

// Question holds all the fields of a question
// and information about the routes given answers.
// Routes are specific to each question.
type Question struct {
	ID       int
	SurveyID int
	Title    string
	// Choices text / possible answer options display values.
	Choices []string
	// AmountPaid to respondents who answer this question (in pence).
	AmountPaid int
	Routes     Router
}

// Router holds information about which question should be answered next.
type Router map[int]int

// NextQuestion reports the question id of the question that should
// be answered next given an answer id for the current question.
func (r Router) NextQuestion(answerID int) (int, bool) {
	id, ok := r[answerID]
	return id, ok
}

// TakerQuestionAnswer holds information about a respondents answers.
// The answer field is the index of the answer from the related question.
type TakerQuestionAnswer struct {
	TakerID    int
	QuestionID int
	Answer     int
}
