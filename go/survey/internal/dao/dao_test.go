package dao_test

import (
	"reflect"
	"testing"

	"github.com/Attest/backend-test/go/model"
	"github.com/Attest/backend-test/go/survey/internal/dao"
)

func TestInMemQuestionDao_Questions(t *testing.T) {
	data := dao.NewInMemQuestionDao()
	type args struct {
		ids []int
	}
	tests := []struct {
		name    string
		args    args
		want    []model.Question
		wantErr error
	}{
		{
			name:    "negative number",
			args:    args{[]int{-2, -1}},
			wantErr: dao.ErrNotFound,
		},
		{
			name:    "doesn't exist",
			args:    args{[]int{812}},
			wantErr: dao.ErrNotFound,
		},
		{
			name: "exists",
			args: args{[]int{-1, 100, 101}},
			want: []model.Question{
				{
					100,
					200,
					"What do you expect to happen to the price of fuel in the UK in the next 6 months?",
					[]string{"Much lower", "A little lower", "Stay about the same", "A little higher", "Much higher"},
					0,
					map[int]int{0: 101, 1: 103, 2: 103, 3: 103, 4: 103},
				},
				{
					101,
					200,
					"Which toothpaste brand do you trust the most?",
					[]string{"Colgate", "Aquafresh", "Oral-B", "Sensodyne", "Pearl Drops", "Supermarket own brand"},
					7,
					map[int]int{0: 102, 1: 102, 2: 102, 3: 102, 4: 102, 5: 102},
				},
			},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			got, err := data.Questions(tt.args.ids)
			if (err != nil) != (tt.wantErr != nil) || err != tt.wantErr {
				t.Errorf("InMemQuestionDao.Questions() error = %v, wantErr %v", err, tt.wantErr)
				return
			}
			if !reflect.DeepEqual(got, tt.want) {
				t.Errorf("InMemQuestionDao.Questions() = %+v, want %+v", got, tt.want)
			}
		})
	}
}

func TestInMemQuestionDao_Question(t *testing.T) {
	data := dao.NewInMemQuestionDao()
	type args struct {
		id int
	}
	tests := []struct {
		name    string
		args    args
		want    *model.Question
		wantErr error
	}{
		{
			name:    "negative number",
			args:    args{id: -1},
			wantErr: dao.ErrNotFound,
		},
		{
			name:    "doesn't exist",
			args:    args{id: 812},
			wantErr: dao.ErrNotFound,
		},
		{
			name: "exists",
			args: args{id: 100},
			want: &model.Question{
				ID: 100, SurveyID: 200,
				Title:      "What do you expect to happen to the price of fuel in the UK in the next 6 months?",
				Choices:    []string{"Much lower", "A little lower", "Stay about the same", "A little higher", "Much higher"},
				AmountPaid: 0, Routes: map[int]int{0: 101, 1: 103, 2: 103, 3: 103, 4: 103},
			},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			got, err := data.Question(tt.args.id)
			if (err != nil) != (tt.wantErr != nil) || err != tt.wantErr {
				t.Errorf("InMemQuestionDao.Question() error = %v, wantErr %v", err, tt.wantErr)
				return
			}
			if !reflect.DeepEqual(got, tt.want) {
				t.Errorf("InMemQuestionDao.Question() = %+v, want %+v", got, tt.want)
			}
		})
	}
}

func TestInMemSurveyDao_QuestionIds(t *testing.T) {
	data := dao.NewInMemSurveyDao()
	type args struct {
		surveyID int
	}
	tests := []struct {
		name    string
		args    args
		want    []int
		wantErr error
	}{
		{
			name:    "negative number",
			args:    args{surveyID: -1},
			wantErr: dao.ErrNotFound,
		},
		{
			name:    "doesn't exist",
			args:    args{surveyID: 812},
			wantErr: dao.ErrNotFound,
		},
		{
			name: "exists",
			args: args{surveyID: 200},
			want: []int{100, 101, 102, 103, 104, 105, 106, 107, 108, 109},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			got, err := data.QuestionIds(tt.args.surveyID)
			if (err != nil) != (tt.wantErr != nil) || err != tt.wantErr {
				t.Errorf("InMemSurveyDao.QuestionIds() error = %v, wantErr %v", err, tt.wantErr)
				return
			}
			if !reflect.DeepEqual(got, tt.want) {
				t.Errorf("InMemSurveyDao.QuestionIds() = %v, want %v", got, tt.want)
			}
		})
	}
}

func TestInMemTakerQuestionAnswerDao_QuestionAnswers(t *testing.T) {
	data := dao.NewInMemTakerQuestionAnswerDao()
	type args struct {
		takerID     int
		questionIDs []int
	}
	tests := []struct {
		name    string
		args    args
		want    []model.TakerQuestionAnswer
		wantErr error
	}{
		{
			name:    "question: negative number",
			args:    args{takerID: 300, questionIDs: []int{-2, -1}},
			wantErr: dao.ErrNotFound,
		},
		{
			name:    "question: doesn't exist",
			args:    args{takerID: 300, questionIDs: []int{812}},
			wantErr: dao.ErrNotFound,
		},
		{
			name:    "taker: negative number",
			args:    args{takerID: -1, questionIDs: []int{-1, 100, 101}},
			wantErr: dao.ErrNotFound,
		},
		{
			name:    "taker: doesn't exist",
			args:    args{takerID: 812, questionIDs: []int{-1, 100, 101}},
			wantErr: dao.ErrNotFound,
		},
		{
			name: "exists",
			args: args{takerID: 300, questionIDs: []int{-1, 100, 101}},
			want: []model.TakerQuestionAnswer{
				{300, 100, 0},
				{300, 101, 1},
			},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			got, err := data.QuestionAnswers(tt.args.takerID, tt.args.questionIDs)
			if (err != nil) != (tt.wantErr != nil) || err != tt.wantErr {
				t.Errorf("InMemTakerQuestionAnswerDao.QuestionAnswers() error = %v, wantErr %v", err, tt.wantErr)
				return
			}
			if !reflect.DeepEqual(got, tt.want) {
				t.Errorf("InMemTakerQuestionAnswerDao.QuestionAnswers() = %v, want %v", got, tt.want)
			}
		})
	}
}

func TestInMemTakerQuestionAnswerDao_QuestionAnswer(t *testing.T) {
	data := dao.NewInMemTakerQuestionAnswerDao()
	type args struct {
		takerID    int
		questionID int
	}
	tests := []struct {
		name    string
		args    args
		want    *model.TakerQuestionAnswer
		wantErr error
	}{
		{
			name:    "question: negative number",
			args:    args{takerID: 300, questionID: -1},
			wantErr: dao.ErrNotFound,
		},
		{
			name:    "taker: negative number",
			args:    args{takerID: -1, questionID: 100},
			wantErr: dao.ErrNotFound,
		},
		{
			name:    "taker: doesn't exist",
			args:    args{takerID: 812, questionID: 100},
			wantErr: dao.ErrNotFound,
		},
		{
			name: "exists",
			args: args{takerID: 300, questionID: 100},
			want: &model.TakerQuestionAnswer{TakerID: 300, QuestionID: 100, Answer: 0},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			got, err := data.QuestionAnswer(tt.args.takerID, tt.args.questionID)
			if (err != nil) != (tt.wantErr != nil) || err != tt.wantErr {
				t.Errorf("InMemTakerQuestionAnswerDao.QuestionAnswer() error = %v, wantErr %v", err, tt.wantErr)
				return
			}
			if !reflect.DeepEqual(got, tt.want) {
				t.Errorf("InMemTakerQuestionAnswerDao.QuestionAnswer() = %v, want %v", got, tt.want)
			}
		})
	}
}
