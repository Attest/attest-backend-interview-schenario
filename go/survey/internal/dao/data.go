package dao

import "github.com/Attest/backend-test/go/model"

// NewInMemQuestionDao is a constructor for a *InMemQuestionDao,
// it is created with mock inmemory data.
func NewInMemQuestionDao() *InMemQuestionDao {
	return &InMemQuestionDao{
		qs: []model.Question{
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
			{
				102,
				200, "What cash offer would lead you to switch your primary bank account?",
				[]string{"Under £100", "£100", "£150", "£200", "Over £250"},
				8,
				map[int]int{0: 105, 1: 105, 2: 105, 3: 105, 4: 105},
			},
			{
				103,
				200,
				"What is more important to you when buying flights?",
				[]string{"Departure & arrival time (significantly)", "Departure & arrival time (slightly)", "Airline (slightly)", "Airline (significantly)"},
				3,
				map[int]int{0: 104, 1: 104, 2: 104, 3: 104},
			},

			{
				104,
				200,
				"How likely are you to watch the next England football match live on TV?",
				[]string{"Very unlikely", "Unlikely", "Not sure", "Likely", "Very likely"},
				5,
				map[int]int{0: 106, 1: 106, 2: 106, 3: 107, 4: 107},
			},
			{
				105,
				200,
				"How do you expect fuel prices to change in the next 12 months?",
				[]string{"Much lower", "A little lower", "Stay about the same", "A little higher", "Much higher"},
				9,
				map[int]int{0: 109, 1: 109, 2: 109, 3: 109, 4: 109},
			},
			{
				106,
				200,
				"If you had to choose to vote Green Party or LibDems, who would you vote for?",
				[]string{"Green Party (definitely)", "Green Party (slightly)", "LibDems (definitely)", "LibDems (slightly)"},
				11,
				map[int]int{0: 109, 1: 109, 2: 109, 3: 109},
			},
			{
				107,
				200,
				"Rank these shoe brands by how fashionable they are",
				[]string{"Nike", "Converse", "Puma", "Adidas", "Dunlop", "Reebok"},
				13,
				map[int]int{0: 108, 1: 108, 2: 108, 3: 108, 4: 108, 5: 108},
			},
			{
				108,
				200,
				"Which type of phone would you consider buying the near future?",
				[]string{"iPhone", "Android", "Windows Phone", "Blackberry", "FireFox OS"},
				5,
				map[int]int{0: 109, 1: 109, 2: 109, 3: 109, 4: 109},
			},

			{
				109,
				200,
				"When do you most often eat cereal for breakfast?",
				[]string{"Every day of the week", "Some weekdays and sometimes weekends", "Most days during the working week", "Only on weekends", "Maybe once or twice", "Never"},
				5,
				nil,
			},
			{
				110,
				201,
				"When you buy high-value electronics (such as a TV or PC), do you need to see them in person first?",
				[]string{"Always", "Sometimes", "Never"},
				0,
				map[int]int{0: 111, 1: 111, 2: 111},
			},
			{
				111,
				201,
				"How have NHS GP waiting times changed over the last year?",
				[]string{"Significantly longer", "A little longer", "Unchanged", "A little shorter", "Significantly shorter"},
				0,
				map[int]int{0: 112, 1: 112, 2: 112, 3: 112, 4: 112},
			},

			{
				112,
				201,
				"Are you answering these questions truthly?",
				[]string{"Never", "No", "Sometimes", "Always"},
				11,
				map[int]int{0: 113, 1: 113, 2: 113, 3: 113},
			},

			{
				113,
				201,
				"Which of these are important to you when buying flights?",
				[]string{"Departure & arrival time", "Cost", "Which airport", "Duration of flight", "Airline history", "Word of mouth recommendations"},
				8,
				nil,
			},
		},
	}
}

// NewInMemSurveyDao is a constructor for a *InMemQuestionDao,
// it is created with mock inmemory data.
func NewInMemSurveyDao() *InMemSurveyDao {
	return &InMemSurveyDao{
		ids: map[int][]int{
			200: {100, 101, 102, 103, 104, 105, 106, 107, 108, 109},
			201: {110, 111, 112, 113},
		},
	}
}

// NewInMemTakerQuestionAnswerDao is a constructor for a *InMemQuestionDao,
// it is created with mock inmemory data.
func NewInMemTakerQuestionAnswerDao() *InMemTakerQuestionAnswerDao {
	return &InMemTakerQuestionAnswerDao{
		answers: map[int][]model.TakerQuestionAnswer{
			300: {
				{300, 100, 0},
				{300, 101, 1},
				{300, 102, 0},
				{300, 105, 1},
				{300, 109, 3},
			},
			301: {
				{301, 100, 1},
				{301, 103, 3},
				{301, 104, 2},
				{301, 106, 0},
				{301, 109, 2},
			},
			302: {
				{302, 100, 1},
				{302, 103, 3},
				{302, 104, 2},
				{302, 106, 3},
			},
			303: {
				{303, 100, 2},
				{303, 103, 1},
			},
		},
	}
}
